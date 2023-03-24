module Playlist (Playlist, nuevaP, actualP, skipP, backP, resetP) where

import Data.Binary.Get (skip)
import FileSystem (agregarF)
import Tema
import Tipos

data Playlist = Play Int [Tema] deriving (Eq, Show)

-- nuevaP :: [ Tema ] →Playlist
-- A partir de una lista de temas crea una nueva Playlist con su  indice en cero.
nuevaP :: [Tema] -> Playlist
nuevaP (x : xs) = Play 0 (x : xs)

-- actualP :: Playlist →Tema
-- Dada una Playlist devuelve el tema en la posicion indicada por el indice.
actualP :: Playlist -> Tema
actualP (Play indice lista) = lista !! indice

-- skipP :: Playlist →Playlist
-- Devuelve una Playlist con su indice aumentado en uno
skipP :: Playlist -> Playlist
skipP (Play indice lista) = Play (indice + 1) lista

-- backP :: Playlist →Playlist
-- Idem anterior pero con el  ́ındice decrementado en uno.
backP :: Playlist -> Playlist
backP (Play indice lista) = Play (indice - 1) lista

-- resetP :: Playlist →Playlist
-- Dada una Playlist crea una nueva con la lista de temas de la original.
resetP :: Playlist -> Playlist
resetP (Play int lista) = nuevaP lista

{-
TEST
setup: primero creamos una "playlistTest", en base a otras
variables temporales que nos permiten llegar a una playlist
que tenga sentido testear. Para hacer esto tambien creamos dos
cancionesTest para evaluar distintos parametros.

1) nos fijamos si nuevaP funciona WLOG
2) nos fijamos si actualP funciona WLOG
3) nos fijamos si skipP funciona WLOG
4) nos fijamos si backP funciona WLOG
5) nos fijamos si resetP funciona con una playlist cuyo indice ya esta en 0
6) nos fijamos si resetP funciona WLOG
-}

cancionBase = nuevoT "nombre" "dato"

cancionTest1 = agregarT "Simpsonwave" cancionBase

cancionTest2 = agregarT "Chicano Rap" cancionBase

playlistTest = nuevaP [cancionTest1, cancionTest2]

testPlaylist = [playlistTest == nuevaP [cancionTest1, cancionTest2], actualP playlistTest == cancionTest1, skipP playlistTest == Play 1 [cancionTest1, cancionTest2], backP (Play 1 [cancionTest1, cancionTest2]) == playlistTest, resetP playlistTest == playlistTest, resetP (Play 1 [cancionTest1, cancionTest2]) == playlistTest]