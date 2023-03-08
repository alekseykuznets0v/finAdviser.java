import java.util.ArrayList;
import java.util.HashMap;
public class ExpensesManager{
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager(){
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        // Замените на работу с таблицей
        if (expensesByCategories.containsKey(category)){ // Проверьте наличие категории
            ArrayList<Double> expensesList = expensesByCategories.get(category); // Получите список трат в этой категории
            expensesList.add(expense); // Добавьте трату
        } else {
            ArrayList<Double> newExpensesList = new ArrayList<>();
            newExpensesList.add(expense); // Создайте новый список трат и добавьте в него сумму
            expensesByCategories.put(category, newExpensesList); // Сохраните категорию и новый список трат в хеш-таблицу
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        // Замените логику для работы с таблицами
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            for (Double expense : expensesByCategories.get(category)){
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)){
            for (Double expense : expensesByCategories.get(category)){
                if (expense > maxExpense){
                    maxExpense = expense;
                }
            }
        } else System.out.println("Такой категории пока нет.");

        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // Таблица называется иначе
        System.out.println("Траты удалены.");
    }

    double getExpensesSum(){
        double expensesSum = 0;
        for (String category : expensesByCategories.keySet()){
            for (Double expense : expensesByCategories.get(category)){
                expensesSum += expense;
            }
        }
        return expensesSum;
    }

    void removeCategory(String name){
        if (expensesByCategories.containsKey(name)){
            System.out.println("Категория " + name + " удалена из таблицы");
            expensesByCategories.remove(name);
        } else System.out.println("Такой категории нет");
    }

    String getMaxCategoryName(){
        double maxCategorySum = 0;
        String maxCategoryName = "";
        for (String category : expensesByCategories.keySet()){
            double categorySum = 0;
            for (Double expense : expensesByCategories.get(category)){
                categorySum += expense;
            }
            if (categorySum > maxCategorySum){
                maxCategorySum = categorySum;
                maxCategoryName = category;
            }
        }
        return maxCategoryName;
    }

}
