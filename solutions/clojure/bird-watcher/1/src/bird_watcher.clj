(ns bird-watcher)

(def last-week 
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (assoc birds (- (count birds) 1) 
         (inc (last birds))))

(defn day-without-birds? [birds]
  (let [no-birds (filter #(= 0 %) birds)]
    (boolean (seq no-birds))))

(defn n-days-count [birds n]
  (loop [i 0
         sum 0]
    (if (>= i n)
      sum
      (recur (inc i) (+ sum (get birds i))))))

(defn busy-days [birds]
  (loop [i 0
         cnt 0]
    (let [b (get birds i)]
      (if (>= i (count birds))
        cnt
        (recur (inc i) (if (>= b 5)
                         (+ cnt 1)
                         cnt))))))

(defn odd-week? [birds]
  (loop [i 0
         is-odd? true]
    (if (>= i (count birds))
      is-odd?
      (let [b (get birds i)
            nb (if (< (inc i) (count birds))
                 (get birds (inc i))
                 (- 1 b))]
        (cond (or (> b 1) (not is-odd?)) false
              (>= i (count birds)) is-odd?
              :else (recur (+ i 2) (not= b nb)))))))
