;; complement

(defn identify-humans
  [social-security-numbers]
  (filter #(not (vampire? %))
          (map vampire-related-details social-security-numbers)))


(def not-vampire? (complement vampire?))
(defn identify-humans
  [social-security-numbers]
  (filter not-vampire?
          (map vampire-related-details social-security-numbers)))


(defn my-complement
  [fun]
  (fn [& args]
    (not (apply fun args))))

(def my-pos? (complement neg?))
(my-pos? 1)
; => true

(my-pos? -1)
; => false
