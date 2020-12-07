(def input (-> "input.txt" slurp (clojure.string/split #"\n")))

(defn- in-pos? 
  [line letter pos]
  (= letter (nth line pos)))

(defn- valid? [line]
  (let [[_ pos1 pos2 letter password] (re-matches #"^(\d+)-(\d+) (.): (.+)$" line)
        pos1 (dec (Integer. pos1))
        pos2 (dec (Integer. pos2)) 
        password (map str password)
        in-pos? (partial in-pos? password letter)] 
    (->> [pos1 pos2]
         (filter in-pos?)
         count
         dec
         zero?)))

(defn solve [input]
  (->> input
       (filter valid?)
       count))

(solve input)

