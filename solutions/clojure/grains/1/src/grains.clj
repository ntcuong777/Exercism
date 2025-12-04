(ns grains)

(defn square
  "Returns the number of grains on the n-th chessboard square."
  [n]
  (apply * (repeat (- n 1) 2N))
  )

(defn total
  "Returns the total number of grains on the chessboard."
  []
  (apply + (map square (range 1 65)))
  )
