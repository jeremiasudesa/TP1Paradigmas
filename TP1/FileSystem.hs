module FileSystem (FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF) where

import Data.List
import Tema
import Tipos

data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

-- nuevoF :: FileSystem
-- Crea un nuevo FileSystem con sus listas vacias.
nuevoF :: FileSystem
nuevoF = FS [] []

-- etiquetasF :: FileSystem →[ Etiqueta ]
etiquetasF :: FileSystem -> [Etiqueta]
etiquetasF (FS etiquetas temas) = etiquetas

-- temasF :: FileSystem →[ Tema ]
temasF :: FileSystem -> [Tema]
temasF (FS etiquetas temas) = temas

-- agregarF :: Tema →FileSystem →FileSystem
-- Agrega el tema y sus etiquetas de ser necesario.
agregarF :: Tema -> FileSystem -> FileSystem
agregarF tema (FS etiquetas temas) = FS (foldr insertarUnico (sort (etiquetasT tema)) etiquetas) (insertarUnico tema temas)
  where
    insertarUnico elemento lista
      | elemento `notElem` lista = insertar elemento lista
      | otherwise = lista

-- 16. filtrarF :: Etiqueta →FileSystem →[ Tema ]
filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF etiqueta (FS etiquetas temas) = [x | x <- temas, aplicaT etiqueta x]

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
cancionTest1 = agregarT "Celtic Punk" cancionBase

cancionTest2 :: Tema
cancionTest2 = agregarT "Horror Country" cancionTest1

fsBase2 :: FileSystem
fsBase2 = agregarF cancionTest1 fsBase

fsTest :: FileSystem
fsTest = agregarF cancionTest2 fsBase2

testFileSystem :: [Bool]
testFileSystem =
  [ fsBase == nuevoF,
    etiquetasF fsTest == ["Celtic Punk", "Horror Country"],
    etiquetasF (agregarF cancionTest1 fsTest) == etiquetasF fsTest,
    temasF fsTest == [cancionTest1, cancionTest2],
    temasF (agregarF cancionTest1 fsTest) == temasF fsTest,
    null (filtrarF "Vegan straight edge" fsTest),
    filtrarF "Celtic Punk" fsTest == [cancionTest1, cancionTest2]
  ]