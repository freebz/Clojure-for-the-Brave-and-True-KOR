;; 자바 상호 운용성

;; 상호 운용성 구문 형식

(.toUpperCase "By Bluebeard's bananas!")
; => "BY BLUEBEARD'S BANANAS!"

(.indexOf "Let's synergize our bleeding edges" "y")
; => 7


"By Bluebeard's bananas!".toUpperCase()
"Let's synergize our bleeding edges".indexOf("y")


(java.lang.Math/abs -3)
; => 3

java.lang.Math/PI
; => 3.141592653589793


(macroexpand-1 '(.toUpperCase "By Bluebeard's bananas!"))
; => (. "By Bluebeard's bananas!" toUpperCase)

(macroexpand-1 '(.indexOf "Let's synergize our bleeding edges" "y"))
; => (. "Let's synergize our bleeding edges" indexOf "y")

(macroexpand-1 '(Math/abs -3))
; => (. Math abs -3)
