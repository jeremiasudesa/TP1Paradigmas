module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT) where

import Tipos ( Nombre, Etiqueta, Datos )

data Tema = Tem Nombre [Etiqueta] Datos deriving (Eq, Show, Ord)

nuevoT :: Nombre -> Datos -> Tema
nuevoT nombre = Tem nombre []

nombreT :: Tema -> Nombre
nombreT (Tem nombre _ _) = nombre

datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

etiquetasT :: Tema -> [Etiqueta]
etiquetasT (Tem _ etiqueta _) = etiqueta

agregarT :: Etiqueta -> Tema -> Tema
agregarT etiqueta (Tem nombre _ datos) = Tem nombre [etiqueta] datos -- dudita, no se si esta bienq que haga esto

aplicaT :: Etiqueta -> Tema -> Bool
aplicaT etiqueta (Tem _ etiquetaTema _) = etiqueta `elem` etiquetaTema