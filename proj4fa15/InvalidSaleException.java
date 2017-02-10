package proj4fa15;
/**
 * <p>
 * Title: InvalidSaleException class
 * </p>
 * <p>
 * Description: InvalidSaleException has just a parameterized constructor and is used
 * when all object of InvalidSaleException is created with String types of parameter.
 * </p>
 *
 * @author Bikash Mainali
 */
@SuppressWarnings("serial")
public class InvalidSaleException extends RuntimeException
{
		/**
		 * Initializes an InvalidSaleException storing an appropriate message
		 * along with the type of the collection (as specified by the user).
		 */
		public InvalidSaleException(String collection)
		{
			super("The sale cannot be completed. " + collection);
		}
	}


