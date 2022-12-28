import React from "react";

const ThemeContext = React.createContext();
// 초기값은 provide에서 처리하도록!
ThemeContext.displayName="ThemeContext";

export default ThemeContext;