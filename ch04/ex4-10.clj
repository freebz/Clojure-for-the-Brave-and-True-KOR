;; 느긋한 배열의 효율성 예시

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))


(time (vampire-related-details 0))
; => "Elapsed time: 1001.042 msecs"
; => {:makes-blood-puns? false, :has-pulse? true, :name "McFishwich"}


(time (def mapped-details (map vampire-related-details (range 0 1000000))))
; => "Elapsed time: 0.049 msecs"
; => #'user/mapped-details


(time (first mapped-details))
; => "Elapsed time: 32030.767 msecs"
; => {:makes-blood-puns? false, :has-pulse? true, :name "McFishwich"}


(time (first mapped-details))
; => "Elapsed time: 0.022 msecs"
; => {:makes-blood-puns? false, :has-pulse? true, :name "McFishwich"}


(time (identify-vampire (range 0 1000000)))
; => "Elapsed time: 32019.912 msecs"
; => {:makes-blood-puns? true, :has-pulse? false, :name "Damon Salvatore"}
