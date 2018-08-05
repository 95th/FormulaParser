import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class FormulaParser {
	private FormulaParser() {
	}

	public static Formula parse(String expression) throws FormulaParseException {
		if (expression == null || expression.isEmpty())
			throw new FormulaParseException("expression cannot be empty");

		try {
			ClassPool pool = ClassPool.getDefault();
			CtClass ctClass = pool.makeClass("FormulaImpl");
			ctClass.addInterface(pool.get(Formula.class.getName()));

			CtMethod method = CtNewMethod.make(functionDef(expression), ctClass);
			ctClass.addMethod(method);

			return (Formula) ctClass.toClass().newInstance();
		} catch (Exception e) {
			throw new FormulaParseException(e.getMessage());
		}
	}

	public static boolean isValid(String expression) {
		if (expression == null || expression.isEmpty())
			return false;

		try {
			ClassPool pool = ClassPool.getDefault();
			CtClass ctClass = pool.makeClass("FormulaTestImpl");
			ctClass.addInterface(pool.get(Formula.class.getName()));

			CtNewMethod.make(functionDef(expression), ctClass);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static String functionDef(String expression) {
		return "public double apply(double r, double p, double c, double s) { return " + expression + "; }";
	}
}
