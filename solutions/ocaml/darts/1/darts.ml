let score (x: float) (y: float): int =
  let r = sqrt (x *. x +. y *. y) in
  if r <= 1.0 then 10
  else if r <= 5.0 then 5
  else if r <= 10.0 then 1
  else 0
