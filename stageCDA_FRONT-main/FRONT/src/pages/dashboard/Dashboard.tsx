import { Title } from "@mui/icons-material";
import React, { PureComponent } from "react";
import {
  AreaChart,
  Area,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  ResponsiveContainer,
  BarChart,
  Bar,
} from "recharts";
import "./Dashboard.css";

const data = [
  {
    name: "jan",
    n0: 4000,
    n1: 2400,
    amt: 4500,
  },
  {
    name: "fev",
    n0: 3000,
    n1: 1398,
    amt: 2210,
  },
  {
    name: "mar",
    n0: 2000,
    n1: 800,
    amt: 2290,
  },
  {
    name: "avr",
    n0: 2780,
    n1: 3908,
    amt: 2000,
  },
  {
    name: "mai",
    n0: 1890,
    n1: 4800,
    amt: 2181,
  },
  {
    name: "jui",
    n0: 2390,
    n1: 3800,
    amt: 2500,
  },
  {
    name: "juil",
    n0: 3490,
    n1: 4300,
    amt: 2100,
  },
  {
    name: "aout",
    n0: 5000,
    n1: 1250,
    amt: 2500,
  },
  {
    name: "sep",
    n0: 5000,
    n1: 1250,
    amt: 2500,
  },
  {
    name: "oct",
    n0: 5400,
    n1: 1250,
    amt: 2500,
  },
  {
    name: "nov",
    n0: 5100,
    n1: 1350,
    amt: 2800,
  },
  {
    name: "dec",
    n0: 5000,
    n1: 1250,
    amt: 2500,
  },
];
const data1 = [
  {
    name: "jan",
    n0: 4000,
    n1: 2400,
    amt: 4500,
  },
  {
    name: "fev",
    n0: 3000,
    n1: 1398,
    amt: 2210,
  },
  {
    name: "mar",
    n0: 2000,
    n1: 800,
    amt: 2290,
  },
  {
    name: "avr",
    n0: 2780,
    n1: 3908,
    amt: 2000,
  },
  {
    name: "mai",
    n0: 1890,
    n1: 4800,
    amt: 2181,
  },
  {
    name: "jui",
    n0: 2390,
    n1: 3800,
    amt: 2500,
  },
  {
    name: "juil",
    n0: 3490,
    n1: 4300,
    amt: 2100,
  },
  {
    name: "aout",
    n0: 5000,
    n1: 1250,
    amt: 2500,
  },
  {
    name: "sep",
    n0: 5000,
    n1: 1250,
    amt: 2500,
  },
  {
    name: "oct",
    n0: 5400,
    n1: 1250,
    amt: 2500,
  },
  {
    name: "nov",
    n0: 5100,
    n1: 1350,
    amt: 2800,
  },
  {
    name: "dec",
    n0: 5000,
    n1: 1250,
    amt: 2500,
  },
];

console.log('toktok', localStorage.getItem('token'))

export default class Dashboard extends PureComponent {
  static demoUrl = "https://codesandbox.io/s/simple-line-chart-kec3v";

  render() {
    return (
      <div className="alldash">
        <div className="topdash">
          <div className="block1">
            <h1>Facture à établir:</h1>
          </div>
          <div className="block2">
            <h1>C.A moyen du mois:</h1>
          </div>
          <div className="block3">
            <h1>Nombre d'impayés:</h1>
          </div>
          <div className="block4">
            <h1>C.A moyen de l'année:</h1>
          </div>
        </div>
        <div className="botdash">
          <div className="left">
            <ResponsiveContainer width="90%" height="90%">
              <BarChart
                data={data}
                margin={{
                  top: 40,
                  right: 30,
                  left: 0,
                  bottom: -10,
                }}
              >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" />
                <YAxis tickCount={11} domain={[0, 10000]} interval={0} />
                <Tooltip />
                <Legend />
                <Bar dataKey="n0" fill="#699" />
                <Bar dataKey="n1" fill="#800" />
                <Bar dataKey="amt" fill="#480" />
              </BarChart>
            </ResponsiveContainer>
          </div>
          <div className="right">
            <ResponsiveContainer width="90%" height="90%">
              <AreaChart
                data={data1}
                margin={{
                  top: 10,
                  right: 30,
                  left: 0,
                  bottom: 0,
                }}
              >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" />
                <YAxis tickCount={11} interval={0} domain={[0, 100000]} />
                <Tooltip />
                <Area
                  type="monotone"
                  dataKey="n0"
                  stackId="1"
                  stroke="#blue"
                  fill="#8884d8"
                />
                <Area
                  type="monotone"
                  dataKey="n1"
                  stackId="1"
                  stroke="#82ca9d"
                  fill="#82ca9d"
                />
                <Area
                  type="monotone"
                  dataKey="amt"
                  stackId="1"
                  stroke="#ffc658"
                  fill="#ffc658"
                />
              </AreaChart>
            </ResponsiveContainer>
          </div>
        </div>
      </div>
    );
  }
}
