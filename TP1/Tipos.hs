module Tipos where

import Data.List

type Datos = String

type Etiqueta = String

type Nombre = String

-- comentamos nuestra definicion del quicksort ya que en la consigna no se aclaraba explicitamente que debiamos implementarlo nosotros
-- quicksort :: (Ord a) => [a] -> [a]
-- quicksort [] = []
-- quicksort (x : xs) =
--   let menoresquehead = quicksort [a | a <- xs, a <= x]
--       mayoresquehead = quicksort [a | a <- xs, a > x]
--    in menoresquehead ++ [x] ++ mayoresquehead

insertar :: Ord a => a -> [a] -> [a]
insertar elemento lista = sort (elemento : lista)

{-
TEST
1) ordenar lista de strings
2) meter una lista vacia
3) ordenar lista de Nums
-}

testTipos :: [Bool]
testTipos =
  [ insertar "tercera" ["ganamos", "la"] == ["ganamos", "la", "tercera"],
    insertar "hola" [] == ["hola"],
    insertar 4.0 [3, 1] == [1, 3, 4.0]
  ]