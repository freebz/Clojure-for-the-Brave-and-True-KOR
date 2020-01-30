;; conj

(conj [0] [1])
; => [0 [1]]


(into [0] [1])
; => [0 1]


(conj [0] 1)
; => [0 1]


(conj [0] 1 2 3 4)
; => [0 1 2 3 4]

(conj {:time "midnight"} [:place "ye olde cemetarium"])
; => {:time "midnight", :place "ye olde cemetarium"}


(defn my-conj
  [target & additions]
  (into target additions))

(my-conj [0] 1 2 3)
; => [0 1 2 3]
