let primes n =
  let is_prime = Array.make (n + 1) true in
  is_prime.(0) <- false;
  if n >= 1 then is_prime.(1) <- false;
  for i = 2 to int_of_float (sqrt (float_of_int n)) do
    if is_prime.(i) then
      for j = i * i to n do
        if j mod i = 0 then is_prime.(j) <- false
      done
  done;
  let primes_list = ref [] in
  for i = 2 to n do
    if is_prime.(i) then primes_list := i :: !primes_list
  done;
  List.rev !primes_list
