;; 함수의 내용

(defn illustrative-function
  []
  (+ 1 304)
  30
  "joe")

(illustrative-function)
; => "joe"


(defn number-comment
  [x]
  (if (> x 6)
    "세상에! 이렇게 큰 숫자라니!"
    "이 정도면 좋은 것 같아."))

(number-comment 5)
; => "이 정도면 좋은 것 같아."

(number-comment 7)
; => "세상에! 이렇게 큰 숫자라니!"
