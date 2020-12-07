(def input (-> "input.txt" slurp (clojure.string/split #"\n")))

(defn- valid? [line]
  (let [[_ pos1 pos2 letter password] (re-matches #"^(\d+)-(\d+) (.): (.+)$" line)
        pos1 (dec (Integer. pos1))
        pos2 (dec (Integer. pos2)) 
        password (map str password)
        in-pos1 (= letter (nth password pos1))
        in-pos2 (= letter (nth password pos2))]
    (println in-pos1 in-pos2)
    (not= in-pos1 in-pos2)))

(defn solve [input]
  (->> input
       (filter valid?)
       count))

(solve input)

