module Tipos where

type Datos = String

type Etiqueta = String

type Nombre = String

quicksort :: (Ord a) => [a] -> [a]
quicksort [] = []
quicksort (x : xs) =
  let menoresquehead = quicksort [a | a <- xs, a <= x]
      mayoresquehead = quicksort [a | a <- xs, a > x]
   in menoresquehead ++ [x] ++ mayoresquehead

insertar :: Ord a => a -> [a] -> [a]
insertar elemento lista = quicksort (elemento : lista)
