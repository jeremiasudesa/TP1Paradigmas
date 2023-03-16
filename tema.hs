module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT )

 where

import Tipos

data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)

nuevoT :: Nombre -> Datos -> Tema
nuevoT nombre datos = Tem nombre [] datos

nombreT :: Tema -> Nombre
nombreT (Tem nombre _ _) = nombre

datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

etiquetasT :: Tema -> [ Etiqueta ]
etiquetasT (Tem _ etiqueta _) = etiqueta

agregarT :: Etiqueta -> Tema -> Tema
agregarT etiqueta (Tem nombre _ datos) = Tem nombre [etiqueta] datos --dudita, no se si esta bienq que haga esto

aplicaT :: Etiqueta -> Tema -> Bool
aplicaT etiqueta (Tem nom et dat) | [etiqueta] == et = True
                                  | otherwise = False



