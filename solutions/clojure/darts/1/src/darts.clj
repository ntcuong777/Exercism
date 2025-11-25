(ns darts)

(defn score
  "Calculates the score of a dart throw."
  [x y]
  (let [unroot-radi (+ (* x x) (* y y))]
    (cond
      (<= unroot-radi 1) 10
      (<= unroot-radi (* 5 5)) 5
      (<= unroot-radi (* 10 10)) 1
      :else 0))
  )
