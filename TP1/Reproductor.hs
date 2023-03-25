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
  ( FileSystem,
    agregarF,
    filtrarF,
    nuevoF,
    temasF,
  )
import Playlist (Playlist, actualP, backP, nuevaP, resetP, skipP)
import Tema (Tema, agregarT, nuevoT)
import Tipos (Etiqueta)

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

-- 17. nuevoR :: FileSystem →Reproductor
-- Crea un nuevo reproductor a partir de un FileSystem y una nueva Playlist con su
-- lista de temas vacıa.
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
TEST: creamos un reproductor base, en base a un filesystem generico, con playlist vacia.
También creamos un reproductorTest y reproductorTest2 para poder testear con playlists no vacias.

1) nos fijamos si reproductorBase funciona WLOG
2) nos fijamos si archivosR funciona WLOG
3) nos fijamos si listaParaR funciona WLOG
4) nos fijamos si temasR funciona WLOG
5) nos fijamos si playR funciona WLOG
6) nos fijamos si actualR funciona WLOG
7) nos fijamos si avanzarR funciona WLOG
8) nos fijamos si retrocederR funciona WLOG
9) nos fijamos si reiniciarR funciona WLOG

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

reproductorTest1 :: Reproductor
reproductorTest1 = nuevoR fsTest

reproductorTest2 :: Reproductor
reproductorTest2 = RP fsTest playlistTest

testReproductor :: [Bool]
testReproductor =
  [ reproductorBase == nuevoR fsBase,
    archivosR reproductorTest1 == fsTest,
    listaParaR "Catstep" reproductorTest1 == [cancionTest2],
    temasR reproductorTest1 == [cancionTest2, cancionTest1],
    playR reproductorTest2 "Unblack metal" == RP fsTest (nuevaP [cancionTest2, cancionTest1]),
    actualR reproductorTest2 == cancionTest1,
    avanzarR reproductorTest2 == RP fsTest (skipP playlistTest),
    retrocederR reproductorTest2 == RP fsTest (backP playlistTest),
    reiniciarR reproductorTest2 == RP fsTest playlistTest
  ]