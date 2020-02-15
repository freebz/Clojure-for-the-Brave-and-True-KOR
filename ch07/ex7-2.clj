;; 클로저 처리 모델 훑어보기

(def addition-list (list + 1 2))
(eval addition-list)
; => 3


(eval (concat addition-list [10]))
; => 13

(eval (list 'def 'lucky-number (concat addition-list [10])))
; => #'user/lucky-number

lucky-number
; => 13
