;; 계산하기 위한 목록 작성

;; 기호와 값의 구별

(let [result expression]
  (println result)
  result)


(defmacro my-print-whoopsie
  [expression]
  (list let [result expression]
        (list println result)
        result))


(defmacro my-print
  [expression]
  (list 'let ['result expression]
        (list 'print 'result)
        'result))
