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
playR (RP fs _) etiqueta = RP fs (nuevaP (filtrarF etiqueta fs))

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