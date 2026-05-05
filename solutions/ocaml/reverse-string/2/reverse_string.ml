let reverse_string s =
  let len = String.length s in
  let result = Bytes.create len in
  for i = 0 to len - 1 do
    Bytes.set result (len - i - 1) s.[i]
  done;
  Bytes.to_string result
