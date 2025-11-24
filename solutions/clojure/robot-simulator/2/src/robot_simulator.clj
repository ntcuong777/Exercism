(ns robot-simulator)

(def ^:private right-turn (cycle [:north :east :south :west]))
(def ^:private left-turn (cycle [:north :west :south :east]))

(defn- member-first-index [x coll]
  (first (keep-indexed #(if (= x %2) %1 nil) coll)))

(defn- advance-x [val]
  (fn [{x :x, y :y}]
    {:x (+ x val)
     :y y}))

(defn- advance-y [val]
  (fn [{x :x, y :y}]
    {:x x
     :y (+ y val)}))

(def ^:private advance-actions-per-direction
  {:north (advance-y 1)
   :east (advance-x 1)
   :south (advance-y -1)
   :west (advance-x -1)})

(defn robot
  "Creates a robot at the given coordinates, facing the given direction.
  - coordinates: {:x, :y}"
  [coordinates direction]
  {:bearing direction :coordinates coordinates})


(defn simulate
  "Simulates the robot's movements based on the given instructions
  and updates its state."
  [instructions robot-state]
  (reduce (fn [{direction :bearing, coord :coordinates} ins]
            (cond (= ins \L) {:bearing (nth left-turn (inc (member-first-index direction left-turn)))
                              :coordinates coord}
                  (= ins \R) {:bearing (nth right-turn (inc (member-first-index direction right-turn)))
                              :coordinates coord}
                  :else      {:bearing direction
                              :coordinates (let [advance-fn (get advance-actions-per-direction direction)]
                                             (advance-fn coord))}))
          robot-state
          instructions))
