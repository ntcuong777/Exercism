(ns resistor-color-duo)

(defn color-code
  [color]
  (let [color-to-idx (apply merge
                            (map-indexed (fn [i x] {x i})
                                         ["black" "brown" "red"
                                          "orange" "yellow"
                                          "green" "blue" "violet"
                                          "grey" "white"]))]
    (color-to-idx color)))

(defn resistor-value
  "Returns the resistor value based on the given colors."
  [colors]
  (let [[fst snd & _] colors
        fst-color (color-code fst)
        snd-color (color-code snd)]
    (+ (* 10 fst-color) snd-color))
  )
