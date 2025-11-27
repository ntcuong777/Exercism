(ns raindrops)

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num]
  (let [drops (apply str (map #(if (= (mod num %1) 0)
                                 %2
                                 "")
                              [3 5 7]
                              ["Pling" "Plang" "Plong"]))]
    (if (= 0 (count drops))
      (str num)
      drops))
  )
