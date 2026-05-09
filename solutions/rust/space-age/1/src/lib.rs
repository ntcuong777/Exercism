// The code below is a stub. Just enough to satisfy the compiler.
// In order to pass the tests you can add-to or change any of this code.

#[derive(Debug)]
pub struct Duration {
    s: u64,
}

impl From<u64> for Duration {
    fn from(s: u64) -> Self {
        Self { s }
    }
}

pub trait Planet {
    fn years_during(d: &Duration) -> f64 {
        let earth_year_seconds = 31557600.0;
        let type_name = std::any::type_name::<Self>();
        let type_name = type_name.rsplit("::").next().unwrap_or(type_name);
        let planet_year_seconds = match type_name {
            "Mercury" => 0.2408467 * earth_year_seconds,
            "Venus" => 0.61519726 * earth_year_seconds,
            "Earth" => earth_year_seconds,
            "Mars" => 1.8808158 * earth_year_seconds,
            "Jupiter" => 11.862615 * earth_year_seconds,
            "Saturn" => 29.447498 * earth_year_seconds,
            "Uranus" => 84.016846 * earth_year_seconds,
            "Neptune" => 164.79132 * earth_year_seconds,
            _ => panic!("Unknown planet"),
        };
        d.s as f64 / planet_year_seconds
    }
}

pub struct Mercury;
pub struct Venus;
pub struct Earth;
pub struct Mars;
pub struct Jupiter;
pub struct Saturn;
pub struct Uranus;
pub struct Neptune;

impl Planet for Mercury {}
impl Planet for Venus {}
impl Planet for Earth {}
impl Planet for Mars {}
impl Planet for Jupiter {}
impl Planet for Saturn {}
impl Planet for Uranus {}
impl Planet for Neptune {}
