module Tipos where

type Datos = String
type Etiqueta = String
type Nombre = String

quicksort :: (Ord a) => [a] -> [a]  
quicksort [] = []  
quicksort (x:xs) =   
    let smallerSorted = quicksort [a | a <- xs, a <= x]  
        biggerSorted = quicksort [a | a <- xs, a > x]  
    in  smallerSorted ++ [x] ++ biggerSorted

insertar :: Ord a => a -> [a] -> [a]
insertar palabra (x:xs) = quicksort (palabra:x:xs)

