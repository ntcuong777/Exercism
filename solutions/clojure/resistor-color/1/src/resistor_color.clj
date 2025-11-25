(ns resistor-color)

(def colors
  ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"]
  )

(defn color-code
  "Returns the numerical value associated with the given color."
  [color]
  (let [color-to-code (apply merge (map-indexed (fn [i x] {x i}) colors))]
    (color-to-code color))
  )
