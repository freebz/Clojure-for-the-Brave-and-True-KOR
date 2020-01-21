;; nil, true, false, 진실성, 등위성, 부울 식

(nil? 1)
; => false

(nil? nil)
; => true


(if "bears eat beets"
  "bears beets Battlestar Galactica")
; => "bears beets Battlestar Galactica"

(if nil
  "This won't be the result because nil if falsey"
  "nil is falsey")
; => "nil is falsey"


(= 1 1)
; => true

(= nil nil)
; => true

(= 1 2)
; => false


(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
; => :large_I_mean_venti

(or (= 0 1) (= "yes" "no"))
; => false

(or nil)
; => nil


(and :free_wifi :hot_coffee)
; => :hot_coffee

(and :feelin_super_cool nil false)
; => nil
