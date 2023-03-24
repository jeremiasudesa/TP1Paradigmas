module Reproductor
  ( Reproductor,
    nuevoR,
    archivosR,
    listaParaR,
    temasR,
    playR,
    actualR,
    avanzarR,
    retrocederR,
    reiniciarR,
  )
where

import FileSystem
import Playlist
import Tema
import Tipos

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

-- 17. nuevoR :: FileSystem →Reproductor
-- Crea un nuevo reproductor a partir de un FileSystem y una nueva Playlist con su
-- lista de temas vac ́ıa.
nuevoR :: FileSystem -> Reproductor
nuevoR fs = RP fs (nuevaP [])

-- 18. archivosR :: Reproductor →FileSystem
archivosR :: Reproductor -> FileSystem
archivosR (RP fs _) = fs

-- 19. listaParaR :: Etiqueta →Reproductor →[Tema]
listaParaR :: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP fs _) = filtrarF etiqueta fs

-- 20. temasR :: Reproductor →[Tema]
temasR :: Reproductor -> [Tema]
temasR (RP fs _) = temasF fs

-- 21. playR :: Reproductor →Etiqueta →Reproductor
playR :: Reproductor -> Etiqueta -> Reproductor
playR (RP fs p) etiqueta = RP fs (nuevaP (listaParaR etiqueta (RP fs p)))

-- 22. actualR :: Reproductor → Tema
actualR :: Reproductor -> Tema
actualR (RP _ playlist) = actualP playlist

-- 23. avanzarR :: Reproductor → Reproductor
avanzarR :: Reproductor -> Reproductor
avanzarR (RP fs playlist) = RP fs (skipP playlist)

-- 24. retrocederR :: Reproductor →Reproductor
retrocederR :: Reproductor -> Reproductor
retrocederR (RP fs playlist) = RP fs (backP playlist)

-- 25. reiniciarR :: Reproductor →Reproductor
reiniciarR :: Reproductor -> Reproductor
reiniciarR (RP fs playlist) = RP fs (resetP playlist)

{-
TEST
setup: primero creamos un "fsBase" que se refiere a un filesystem vacio. Luego,
en base a otras variables temporales, llegamos a un filesystem
que tenga sentido testear. Para hacer esto tambien creamos dos
cancionesTest para evaluar distintos parametros.

1) nos fijamos si fsBase es igual a un filesystem vacio, evaluando nuevoF
2) nos fijamos si etiquetasF funciona WLOG
3) nos fijamos si agregarF funciona correctamente en cuanto a etiquetas haciendo uso de etiquetasF WLOG
4) nos fijamos si temasF funciona WLOG
5) nos fijamos si agregarF funciona correctamente en cuanto a temas haciendo uso de temasF WLOG
6) nos fijamos si filtrarF funciona en caso que la etiqueta no este en el FS
7) nos fijamos si filtrarF funciona WLOG

-}

fsBase :: FileSystem
fsBase = nuevoF

cancionBase :: Tema
cancionBase = nuevoT "nombre" "dato"

cancionTest1 :: Tema
cancionTest1 = agregarT "Unblack metal" cancionBase

cancionTest2 :: Tema
cancionTest2 = agregarT "Catstep" cancionTest1

fsBase2 :: FileSystem
fsBase2 = agregarF cancionTest1 fsBase

fsTest :: FileSystem
fsTest = agregarF cancionTest2 fsBase2

playlistTest :: Playlist
playlistTest = nuevaP [cancionTest1, cancionTest2]

reproductorBase :: Reproductor
reproductorBase = nuevoR fsBase

reproductorTest :: Reproductor
reproductorTest = nuevoR fsTest

reproductorTest2 :: Reproductor
reproductorTest2 = RP fsTest playlistTest

testReproductor :: [Bool]
testReproductor =
  [ reproductorBase == nuevoR fsBase,
    archivosR reproductorTest == fsTest,
    listaParaR "Catstep" reproductorTest == [cancionTest2],
    temasR reproductorTest == [cancionTest2, cancionTest1],
    playR reproductorTest2 "Unblack metal" == RP fsTest (nuevaP [cancionTest2, cancionTest1]),
    actualR reproductorTest2 == cancionTest1,
    avanzarR reproductorTest2 == RP fsTest (skipP playlistTest),
    retrocederR reproductorTest2 == RP fsTest (backP playlistTest),
    reiniciarR reproductorTest2 == RP fsTest playlistTest
  ]