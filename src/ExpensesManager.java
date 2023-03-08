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

        if (expensesByCategories.containsKey(category)){
            ArrayList<Double> expensesList = expensesByCategories.get(category);
            expensesList.add(expense);
        } else {
            ArrayList<Double> newExpensesList = new ArrayList<>();
            newExpensesList.add(expense);
            expensesByCategories.put(category, newExpensesList);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
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
        expensesByCategories.clear();
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
