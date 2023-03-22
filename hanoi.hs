data Stick = Vacio | Stack Stick Int deriving (Show, Eq)

pop :: Stick -> Stick
pop (Stack c _) = c
pop Vacio = error "Stack vacio"

top :: Stick -> Int
top (Stack _ e) = e
