/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int importanceSum = 0;
    public int getImportance(List<Employee> employees, int id) {
        for(Employee employee : employees) {
            if(employee.id == id) {
                importanceSum += employee.importance;
                for(int subordinateId : employee.subordinates) {
                    getImportance(employees, subordinateId);
                }
            }
        }
        return importanceSum;
    }
}