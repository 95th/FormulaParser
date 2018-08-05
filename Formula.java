public interface Formula {

	double apply(double r, double p, double c, double s);
	
	default double max(double a, double b) {
		return Math.max(a, b);
	}

	default double max(double a, double b, double c) {
		return max(a, max(b, c));
	}

	default double max(double a, double b, double c, double d) {
		return max(a, max(b, c, d));
	}

	default double max(double a, double b, double c, double d, double e) {
		return max(a, max(b, c, d, e));
	}

	default double max(double a, double b, double c, double d, double e, double... more) {
		double m = max(a, b, c, d, e);
		for (double f : more) {
			m = max(m, f);
		}
		return m;
	}

	default double min(double a, double b) {
		return Math.min(a, b);
	}

	default double min(double a, double b, double c) {
		return min(a, min(b, c));
	}

	default double min(double a, double b, double c, double d) {
		return min(a, min(b, c, d));
	}

	default double min(double a, double b, double c, double d, double e) {
		return min(a, min(b, c, d, e));
	}

	default double min(double a, double b, double c, double d, double e, double... more) {
		double m = min(a, b, c, d, e);
		for (double f : more) {
			m = min(m, f);
		}
		return m;
	}

	default double avg(double a, double b) {
		return (a + b) / 2;
	}

	default double avg(double a, double b, double c) {
		return (a + b + c) / 3;
	}

	default double avg(double a, double b, double c, double d) {
		return (a + b + c + d) / 4;
	}

	default double avg(double a, double b, double c, double d, double e) {
		return (a + b + c + d + e) / 5;
	}

	default double avg(double a, double b, double c, double d, double e, double... more) {
		double total = a + b + c + d + e;
		for (double f : more) {
			total += f;
		}
		return total / (more.length + 5);
	}
}
