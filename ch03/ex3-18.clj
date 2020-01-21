;; 집합

#{"kurt vonnegut" 20 :icicle}


(hash-set 1 1 2 2)
; => #{1 2}


(conj #{:a :b} :b)
; => #{:a :b}


(set [3 3 3 4 4])
; => #{3 4}


(contains? #{:a :b} :a)
; => true

(contains? #{:a :b} 3)
; => false

(contains? #{nil} nil)
; => true


(:a #{:a :b})
; => :a


(get #{:a :b} :a)
; => :a

(get #{:a nil} nil)
; => nil

(get #{:a :b} "kurt vonnegut")
; => nil
