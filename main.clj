(println
  (let [n (Integer/parseInt (read-line))
        abs (fn [n] (if (< n 0) (- 0 n) n))
        a (for [temp (range n)]  (map #(Integer/parseInt %) (clojure.string/split (read-line) #" ")))]
    (abs
      (loop [up 0
             down (dec n)
             sum 0]
        (let [upLine (nth a up)
              downLine (nth a down)]
          (if (< (- down up) 1)
            sum
            (recur
              (inc up)
              (dec down)
              (+
                 sum
                 (- (nth upLine up) (nth upLine down))
                 (- (nth downLine down) (nth downLine up))))))))))
