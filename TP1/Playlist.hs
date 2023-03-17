module Playlist (Playlist, nuevaP, actualP, skipP, backP, resetP) where

import Tema (Tema)
import Tipos ()

data Playlist = Play Int [Tema] deriving (Eq, Show)

-- A partir de una lista de temas crea una nueva Playlist con su  indice en cero.
nuevaP :: [Tema] -> Playlist
nuevaP (x : xs) = Play 0 (x : xs)

-- Dada una Playlist devuelve el tema en la posici ́on indicada por el indice.
actualP :: Playlist -> Tema
actualP (Play indice lista) = lista !! indice

-- Devuelve una Playlist con su indice aumentado en uno
skipP :: Playlist -> Playlist
skipP (Play indice lista) = Play (indice + 1) lista

-- Idem anterior pero con el  ́ındice decrementado en uno.
backP :: Playlist -> Playlist
backP (Play indice lista) = Play (indice - 1) lista

-- Dada una Playlist crea una nueva con la lista de temas de la original.
resetP :: Playlist -> Playlist
resetP (Play int lista) = nuevaP lista
