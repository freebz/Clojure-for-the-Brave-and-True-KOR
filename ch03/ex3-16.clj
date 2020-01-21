;; 벡터

[3 2 1]


(get [3 2 1] 0)
; => 3


(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)
; => {:name "Pugsley Winterbottom"}


(vector "creepy" "full" "moon")
; => ["creepy" "full" "moon"]


(conj [1 2 3] 4)
; => [1 2 3 4]
