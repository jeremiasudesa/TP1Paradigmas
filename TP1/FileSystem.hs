module FileSystem (FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF) where

import Tema
import Tipos

data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF :: [Etiqueta] -> [Tema] -> FileSystem
nuevoF = FS

etiquetasF :: FileSystem -> [Etiqueta]
etiquetasF (FS etiquetas temas) = etiquetas

temasF :: FileSystem -> [Tema]
temasF (FS etiquetas temas) = temas

-- Agrega el tema y sus etiquetas de ser necesario.
agregarF :: Tema -> FileSystem -> FileSystem
agregarF tema (FS etiquetas temas) = (FS etiquetas temas)

-- 16. filtrarF :: Etiqueta →FileSystem →[ Tema ]
filtrarF :: Etiqueta -> FileSystem -> [Tema]
filtrarF etiqueta (FS etiquetas temas) = [x | x <- temas, aplicaT etiqueta x]