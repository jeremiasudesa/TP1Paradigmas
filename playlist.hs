module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
  where

import Tipos
import Tema
import Data.Array (indices)
import Main (lista)

data Playlist = Play Int [ Tema ] deriving (Eq, Show)

nuevaP :: [ Tema ] -> Playlist
nuevaP (x:xs) = Play 0 (x:xs)

actualP :: Playlist -> Tema
actualP (Play indice lista) = lista !! indice

skipP :: Playlist -> Playlist
skipP (Play indice lista) = Play (indice + 1) lista

backP :: Playlist -> Playlist
skipP (Play indice lista) = Play (indice - 1) lista


