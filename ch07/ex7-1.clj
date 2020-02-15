;; 클로저 연금술: 읽기, 계산하기, 매크로

(defmacro backwards
  [form]
  (reverse form))

(backwards (" backwards" " am" "I" str))
; => "I am backwards"
