(ns etl)

(defn transform
  [source]
  (let [inverted (apply merge (map (fn [[score letters]]
                                     (into {} (map #(vector (.toLowerCase %) score) letters)))
                                   source))]
    inverted)
  )
