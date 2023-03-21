module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT) where

import Tipos (Datos, Etiqueta, Nombre)

data Tema = Tem Nombre [Etiqueta] Datos deriving (Eq, Show, Ord)

nuevoT :: Nombre -> [Etiqueta] -> Datos -> Tema -- faltaba etiqueta, preguntar al profe.
nuevoT nombre datos = Tem nombre []

nombreT :: Tema -> Nombre
nombreT (Tem nombre _ _) = nombre

datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

etiquetasT :: Tema -> [Etiqueta]
etiquetasT (Tem _ etiqueta _) = etiqueta

agregarT :: Etiqueta -> Tema -> Tema
agregarT etiqueta (Tem nombre _ datos) = Tem nombre [etiqueta] datos

aplicaT :: Etiqueta -> Tema -> Bool
aplicaT etiqueta (Tem _ etiquetaTema _) = etiqueta `elem` etiquetaTema
