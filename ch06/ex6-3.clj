;; 명칭공간 만들고 바꾸기

(create-ns 'cheese.taxonomy)
; => #namespace[cheese.taxonomy]

(ns-name (create-ns 'cheese.taxonomy))
; => cheese.taxonomy


(in-ns 'cheese.analysis)
; => #namespace[cheese.analysis]


(in-ns 'cheese.taxononmy)
(def cheddars ["mild" "medium" "strong" "sharp" "extra sharp"])
(in-ns 'cheese.analysis)
cheddars
; => Exception: Unable to resolve symbol: cheddars in this context


cheese.taxononmy/cheddars
; => ["mild" "medium" "strong" "sharp" "extra sharp"]
