using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Telecom.Models
{
    public class Request
    {
        private int id;
        private DateTime dateRequested;
        private Service service;
        private string userRequested;
        private string status;

        public int Id { get => id; set => id = value; }
        public DateTime DateRequested { get => dateRequested; set => dateRequested = value; }
        public Service Service { get => service; set => service = value; }
        public string UserRequested { get => userRequested; set => userRequested = value; }
        public string Status { get => status; set => status = value; }

        public Request(DateTime dateRequested, Service service, string userRequested, string status)
        {
            this.dateRequested = dateRequested;
            this.service = service;
            this.userRequested = userRequested;
            this.status = status;
        }

        public Request()
        {
        }
    }
}