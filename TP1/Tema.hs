module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT) where

import Tipos (Datos, Etiqueta, Nombre)

data Tema = Tem Nombre [Etiqueta] Datos deriving (Eq, Show, Ord)

-- nuevoT :: Nombre →Datos →Tema
nuevoT :: Nombre -> Datos -> Tema
nuevoT nombre = Tem nombre []

-- nombreT :: Tema →Nombre
nombreT :: Tema -> Nombre
nombreT (Tem nombre _ _) = nombre

-- datosT :: Tema →Datos
datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

-- etiquetasT :: Tema →[ Etiqueta ]
etiquetasT :: Tema -> [Etiqueta]
etiquetasT (Tem _ etiquetas _) = etiquetas

-- agregarT :: Etiqueta →Tema →Tema
agregarT :: Etiqueta -> Tema -> Tema
agregarT etiqueta (Tem nombre etiquetas datos) = Tem nombre (etiqueta : etiquetas) datos

-- aplicaT :: Etiqueta →Tema →Bool
aplicaT :: Etiqueta -> Tema -> Bool
aplicaT etiqueta (Tem _ etiquetaTema _) = etiqueta `elem` etiquetaTema

{-
TEST
setup: primero creamos una "cancion test", en base a otras
variables temporales que nos permiten llegar a un tema
que tenga sentido testear. Tambien usamos cancionBase1
para los tests sobre una lista de etiquetas vacia.

1) nos fijamos si nuevoT funciona WLOG
2) nos fijamos si nombreT funciona WLOG
3) nos fijamos si datosT funciona WLOG
4) nos fijamos si devuelve las etiquetas de la cancion cuando la lista no es vacia
5) 4) pero con lista vacia
6) nos fijamos que devuelve aplicaT con una etiqueta que no pertenece a la cancion
7) 6) pero cuando aplica
8) 6) pero cuando la lista esta vacia
-}

cancionBase1 = nuevoT "nombre" "dato"

cancionBase2 = agregarT "plunderphonics" cancionBase1

cancionTest = agregarT "bubblegum bass" cancionBase2

testTema = [cancionBase1 == Tem "nombre" [] "dato", nombreT cancionTest == "nombre", datosT cancionTest == "dato", etiquetasT cancionTest == ["bubblegum bass", "plunderphonics"], null (etiquetasT cancionBase1), not (aplicaT "avant garde" cancionTest), aplicaT "plunderphonics" cancionTest, not (aplicaT "plunderphonics" cancionBase1)]
