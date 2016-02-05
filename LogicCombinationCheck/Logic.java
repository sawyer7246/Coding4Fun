
    private void test(){
        String[] logic_1 = new String[]{status_1.STATUS, status_2.STATUS, status_3.STATUS, "" };
        String[] logic_2 = new String[]{status_1.STATUS+"/"+status_1.STATUS_1, status_2.STATUS+"/"+status_2.STATUS, status_3.STATUS, "" };
    }
     /**
     * 有效时间控制矩阵表
     * 
     * @param status_1 
     * @param status_2 
     * @param status_3 
     * @param status_4 
     */
    private  boolean  statusLogicCombinationCheck(List<String[]> logicArr, String status_1, String status_2,String status_3, String status_4){
        for(int i=0,len = logicArr.size() ; i <len ; i++){
            String[] tempStr = logicArr.get(i);
            if(checkValueInArray(status_1,tempStr[0])){
//                状态1
                 if(checkValueInArray(status_2,tempStr[1])){
//                   状态2
                     if(checkValueInArray(status_3,tempStr[2])){
//                       状态3
                         if(checkValueInArray(status_4,tempStr[3])){
//                          状态4
                             return true;
                             }
                         }
                    }
                }
            }
        return false;
    }

    //检查str是否在配置值的str数组中
    private  boolean checkValueInArray(String str , String testStrArr){
        if(StringUtil.isEmpty(testStrArr)){
            //如果判断的值数组为空，代表不需要判断，直接返回真
            return true;
        }
        //先split testStrArr
        String[] strArr = testStrArr.trim().split("/");
        for(int k = 0 ,len = strArr.length ; k< len ;k++){
            if(StringUtils.equals(str, strArr[k])){
                return true;
            }
        }
        return false;
    }
