;; 추려 뽑기

;; 집합에서 첫 번째 원소를 반환한다
(defn my-first
  [[first-thing]] ; first-thing이 벡터에 포함된 점에 유의하자
  first-thing)

(my-first ["oven" "bike" "war-axe"])
; => "oven"


(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "첫 번째 선택: " first-choice))
  (println (str "두 번째 선택: " second-choice))
  (println (str "나머지 선택은 무시할 겁니다. "
                "한탄할 만한 것은 이것들입니다.: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])
; => 첫 번째 선택: Marmalade
; => 두 번째 선택: Handsome Jack
; => 나머지 선택은 무시할 겁니다. 한탄할 만한 것은 이것들입니다.: Pigpen, Aquaman


(defn 보물-위치-공표
  [{lat :lat lng :lng}]
  (println (str "보물위치 위도: " lat))
  (println (str "보물위치 경도: " lng)))
(보물-위치-공표 {:lat 28.22 :lng 81.33})
; => 보물위치 위도: 28.22
; => 보물위치 경도: 81.33


(defn 보물-위치-공표
  [{:keys [lat lng]}]
  (println (str "보물위치 위도: " lat))
  (println (str "보물위치 경도: " lng)))


(defn 보물-위치-접수
  [{:keys [lat lng] :as 보물-위치}]
  (println (str "보물위치 위도: " lat))
  (println (str "보물위치 경도: " lng))

  ;; 먀치 모불선에 새로운 좌표값을 입력하는 것처럼 보인다.
  (배를 조종하라! 보물-위치))
