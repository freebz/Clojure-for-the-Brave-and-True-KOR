;; apply

(max 0 1 2)
; => 2


(max [0 1 2])
; => [0 1 2]


(apply max [0 1 2])
; => 2


(defn my-into
  [target additions]
  (apply conj target additions))

(my-into [0] [1 2 3])
; => [0 1 2 3]
